#include<bits/stdc++.h>
using namespace std;
int main(){
int N , M , ans1 , ans2=1000000000 , ans;
  cin>>N>>M;
  vector<int> A(N) , B(N) , C(M) , D(M);
    for(int i =0;i<N;i++){
    cin>>A[i]>>B[i];
  }
    for(int i =0;i<M;i++){
    cin>>C[i]>>D[i];
  }
  for(int i =0;i<N;i++){
    ans2=1000000000;
    for(int j=0;j<M;j++){
      ans1=abs(A[i]-C[j])+abs(B[i]-D[j]);
      if(ans2>ans1){
        ans2=ans1;
        ans=j;
      }
      }
      cout<<ans+1<<endl;
  }
}