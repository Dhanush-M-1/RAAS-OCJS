#include<bits/stdc++.h>
using namespace std;

int n;
set<int> s;

int main(){
  scanf("%d",&n);
  for(int i=0;i<n;i++){
    int x,y;
    scanf("%d %d",&x,&y);
    
    int z=x+y;
    while(s.count(z)>0){
      s.erase(z);
      z++;
    }
    s.insert(z);
  }
  set<int> :: iterator it;
  for(it=s.begin();it!=s.end();it++)
    cout<< *it <<' '<<0<<endl;
  return 0;
}