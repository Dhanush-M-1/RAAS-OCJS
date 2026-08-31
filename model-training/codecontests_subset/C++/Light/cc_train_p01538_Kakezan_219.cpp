#include<iostream>
#include<vector>
using namespace std;
int Q;
int A;
int t[1000005];
int ans[105];

void solve(int y){
  int cnt=0;
  while(A>=10){
    if(t[A]==y||ans[t[A]]==-1){
      ans[y]=-1;      break;    }
    t[A]=y;
    int x=-1;
    for(int i=10;i<A;i*=10){
      int a=A/i,b=A%i;
      x=max(x,a*b);
    }
    A=x;
    cnt++;
  }
  ans[y]=cnt;
}

int main(){
  cin>>Q;
  for(int i=1;i<=Q;i++){
    cin>>A;
    solve(i);
  }
  for(int i=1;i<=Q;i++)cout<<ans[i]<<endl;
  return 0;
}