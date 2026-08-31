#include <bits/stdc++.h>
using namespace std;
int main(void){
    int a,b,c,d;
    cin>>a>>b>>c;
    d=a+b+c;
    cout<<((d%2==0&&(d/2==a||d/2==b||d/2==c))?"Yes":"No")<<endl;
}
