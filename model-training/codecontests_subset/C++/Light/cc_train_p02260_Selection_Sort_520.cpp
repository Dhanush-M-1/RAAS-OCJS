#include <bits/stdc++.h>
#define N 101
using namespace std;

int main(){
  int n;
  cin>>n;
  int A[N],cnt=0;
  for(int i=0;i<n;i++)cin>>A[i];

  for(int i=0;i<n-1;i++){
    int idx = i;
    for(int j=i;j<n;j++)
      if(A[j]<A[idx])idx = j;
    cnt+=i!=idx;
    swap(A[i],A[idx]);
  }

  for(int i=0;i<n;i++){
    if(i)cout<<" ";
    cout<<A[i];
  }
  cout<<endl;  
  
  cout<<cnt<<endl;

  return 0;
}