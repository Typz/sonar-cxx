class A{
public:
    int foo();
    int i;
};

int A::foo(){};

A* foo(){
    return new A();
}

A bar(){
    return A();
}

#define some \
    9weird \
    stuff

  #define other \
    9weird \
    stuff

  # define more \
    9weird \
    stuff

int main(int argc, char** argv)
{
    int i = 0;
    i -= 1;
    
    const char* lala = \
        "hello world";
    lala = "hello"
        "evil"
        "world";
    
    return foo()->i;
}

struct Point { int x, y; };
Point p = { .y = 45, .x = 72 };

int a[6] = { [4] = 29, [2] = 15 };

int widths[200] = { [0 ... 9] = 1, [10 ... 99] = 2, [100] = 3 };