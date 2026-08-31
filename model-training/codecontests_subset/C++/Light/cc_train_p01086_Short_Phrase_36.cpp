#include<iostream>
#include<string>
using namespace std;
int main(){
  int n;
  while(cin >> n,n){
    int i,j,k;
    string buf;
    int d[50]={};
    for(i=0;i<n;i++){
      cin >> buf;
      d[i]=buf.size();
    }
    for(i=0;i<n;i++){
      int c=0;
      j=i;
      while(c<5) c+=d[j++];
      if(c!=5) continue;
      c=0;
      while(c<7) c+=d[j++];
      if(c!=7) continue;
      c=0;
      while(c<5) c+=d[j++];
      if(c!=5) continue;
      c=0;while(c<7) c+=d[j++];
      if(c!=7) continue;
      c=0;
      while(c<7) c+=d[j++];
      if(c!=7) continue;
      c=0;
      cout << i+1 << endl;
      break;
    }
  }
  return 0;
}