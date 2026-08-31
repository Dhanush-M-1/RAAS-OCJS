#include<iostream>
using namespace std;
int main(){
  int N,M;
  cin>>N>>M;
  int A[50],B[50],C[50],D[50];
  for(int i=0;i<N;i++){
    cin>>A[i]>>B[i];
  }
  for(int i=0;i<M;i++){
    cin>>C[i]>>D[i];
  }
  for(int i=0;i<N;i++){
    int ans=400000001;
    int num=0;
    for(int j=0;j<M;j++){
      int dis=abs(A[i]-C[j])+abs(B[i]-D[j]);
      if(dis<ans){
        ans=dis;
        num=j;
      }
    }
    cout<<num+1<<endl;
  }
}
      
    