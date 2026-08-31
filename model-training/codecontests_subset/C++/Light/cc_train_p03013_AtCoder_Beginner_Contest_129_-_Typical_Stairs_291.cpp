#include<bits/stdc++.h>
using namespace std;
#define MAX 1000000007
int main(){
  long long int N,M,x;
  cin>>N>>M;
  int arr[N+1];
  unsigned long long int sum[N+1];
  memset(arr,1,sizeof arr);memset(sum,0,sizeof sum);
  while(M--) {cin>>x;arr[x]=0;}
  sum[0]=1;
  if(arr[1]) sum[1]=1;
  for(long long int i=2;i<=N;i++)
    if(arr[i]) sum[i]=(sum[i-1]+sum[i-2])%MAX;
  cout<<sum[N]%MAX;
}