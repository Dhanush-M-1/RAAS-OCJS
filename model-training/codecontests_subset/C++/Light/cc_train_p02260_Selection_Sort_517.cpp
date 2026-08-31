#include<iostream>
#include<algorithm>
using namespace std;
  
int main(){
  int n,A[100],mini,count=0;
  cin>>n;
  for(int i=0;i<n;i++)cin>>A[i];
    
  for(int i=0;i<n-1;i++){
    mini=i;
    for(int j=i+1;j<n;j++){
      if(A[j]<A[mini])mini=j;
    }
      
    if(i!=mini){
      count++;
      swap(A[i],A[mini]);
    }
  }
    
  for(int i=0;i<n;i++){
    if(i)cout<<' ';
    cout<<A[i];
  }
  cout<<endl<<count<<endl;
  
  return 0;
}
