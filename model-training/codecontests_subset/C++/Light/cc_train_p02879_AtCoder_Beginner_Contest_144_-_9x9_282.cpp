#include <iostream>

int main(){
    int a,b;
    std::cin >> a >> b;
    std::cout << ((a >= 10 || b >= 10) ? -1 : a*b) << "\n";
}