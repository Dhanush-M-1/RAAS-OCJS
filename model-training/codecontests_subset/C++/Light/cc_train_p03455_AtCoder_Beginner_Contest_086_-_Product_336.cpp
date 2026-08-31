#include <iostream>
using namespace std;
int main(void){
    int a, b;
    cin >> a >> b;
    a*b%2 == 0 ? cout << "Even" : cout << "Odd";
}
