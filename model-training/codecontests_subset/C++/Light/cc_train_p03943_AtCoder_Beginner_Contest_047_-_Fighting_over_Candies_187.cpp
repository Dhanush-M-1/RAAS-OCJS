#include<bits/stdc++.h>
using namespace std;

int main(){
    int a,b,c;
    cin>>a>>b>>c;
    cout<<(2*max({a,b,c})==a+b+c?"Yes":"No")<<endl;
    return 0;
}