class process:
    def __init__(self,data,size):
        self.data=data
        self.size=size
        self.next=None

class memory:
     def __init__(self):
         self.msize=1700
         self.os=300
         self.head=process('os',300)
         self.c=300 #memory allocate at the moment Used when loading processes
         self.absolute=300 #Absolute memory allocated

     def search(self,p):
        t=p.data
        c=self.head
        while c.next!=None:
            if c.data==t:
                return True
            else:
                c=c.next
        return False

     def loadprocess(self,p,s):
        a=process(p,s)
        if self.head==None:
            self.head=a
            self.c=self.c+a.size
        else:
            current=self.head
            p=None
            if self.search(a)==False:
                while current.next!=None:
                    if current.next.data==None and current.next.size>=a.size:
                        sizet=current.next.size
                        a.next=current.next.next
                        current.next=a
                        print("%s loaded to memory"%(a.data))
                        if sizet>a.size:
                            b=process(None,sizet-a.size)
                            b.next=a.next
                            a.next=b
                        self.absolute=self.absolute+a.size
                        return
                    else:
                        current=current.next
                    
                if (self.msize-self.c)>=a.size:
                        current.next=a
                        print("%s loaded to memory"%(a.data))
                        self.c=self.c+a.size
                        self.absolute=self.absolute+a.size
                else:
                    print("No space---SORRY")
     def removeprocess(self,p):
        current=self.head
        if current.data==p:
            print("You are going to remove the OS")
            current.next=self.head
            return
        while current.next!=None:
            if current.next.data==p:
                print("%s Process terminated"%(current.next.data))
                current.next.data=None
                self.absolute=self.absolute-current.next.size
                return
            else:
                current=current.next
        print("Can't find the process")

     def printPr(self):
        current=self.head
        print("OS is %d Bytes"%(current.size))
        while current.next!=None:
            if current.next.data==None:
                print("Free block %d"%(current.next.size))
            else:
                print("Process is %s and the size is %d Bytes\n"%(current.next.data,current.next.size))
            current=current.next
        print("================================================================================")
        print("Free area of the memory %d Bytes"%(self.msize-self.absolute))
        print("================================================================================")
