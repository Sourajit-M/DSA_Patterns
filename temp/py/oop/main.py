class Demo:
    class Human:
        def __init__(self, name, age, salary):
            self.name = name
            self.age = age
            self.salary = salary
    
    def instance_method(self):
        print("Instance method called")
    
    def add(self, a: int, b: int):
        print(f"Addition = {a + b}")
    
    def intro(self, human : Human):
        print(f"Name: {human.name}, Age: {human.age}, Salary : {human.salary}")



d = Demo()

person = d.Human("Eshita", 20, 0)
d.intro(person)


