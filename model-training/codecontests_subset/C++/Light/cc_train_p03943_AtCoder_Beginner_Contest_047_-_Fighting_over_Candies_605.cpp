#include <iostream>
#include <algorithm>
using namespace std;

int main(void){
    int a,b,c;
    cin>>a>>b>>c;
    cout<<((a+b+c)==max({a,b,c})*2?"Yes":"No")<<endl;
}