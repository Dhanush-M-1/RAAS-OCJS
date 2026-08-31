#include<bits/stdc++.h>
using namespace std;
int a,b;
int main(){
    cin>>a>>b;
    if(min(a,b)>=1 && max(a,b)<=9)cout<<a*b;
    else cout<<-1;
}