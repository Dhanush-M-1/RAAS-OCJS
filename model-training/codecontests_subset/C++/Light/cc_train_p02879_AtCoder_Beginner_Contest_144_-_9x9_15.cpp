#include<bits/stdc++.h>
using namespace std;
int main(void){
  int a,b; cin>>a>>b;
  if(max(a,b)>9) cout<<-1; else cout<<a*b;
  return 0;
}