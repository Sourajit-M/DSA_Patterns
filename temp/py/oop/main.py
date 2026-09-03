class Demo:

    def instance_method(self):
        print(f"Instance method is called using objects")
    
    @staticmethod
    #if we dont use static we will need self but with static we dont need
    def add(a:int, b:int):
        print(f"Addition = ", (a+b))
    

d = Demo()
d.instance_method()
d.add(2, 3)
