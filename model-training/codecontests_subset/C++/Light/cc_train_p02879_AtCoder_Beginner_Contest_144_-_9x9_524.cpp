#include<bits/stdc++.h>
using namespace std;
int main(){
  int a,b;cin>>a>>b;
  if(max(a,b)>9)cout<<-1<<endl;
  else cout<<a*b<<endl;
}