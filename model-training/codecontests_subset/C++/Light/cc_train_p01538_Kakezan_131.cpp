#include <cstdio>

int p10[10];
int max(int a,int b){return a>b?a:b;}

int tejun2(int n){
  int ans=-1;
  for(int i=1; p10[i]<n; i++)
    ans=max(ans,(n/p10[i])*(n%p10[i]));
  return ans;
}

int main(){
  p10[0]=1;
  for(int i=1; i<10; i++)p10[i]=p10[i-1]*10;

  int Q,N;

  scanf("%d",&Q);
  for(int i=0; i<Q; i++){
    int cnt;
    scanf("%d",&N);
    for(cnt=0; N>=10&&cnt<100000; cnt++){
      N=tejun2(N);
    }
    if(cnt==100000)
      printf("-1\n");
    else
      printf("%d\n",cnt);
  }
}