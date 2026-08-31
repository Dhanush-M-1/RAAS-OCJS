#include<iostream>
#include<set>
using namespace std;
int main(){
  int Q,N;
  int ans;
  cin>>Q;
  for(int i=0;i<Q;i++){
    cin>>N;
    set<int>used;
    bool ok=true;
    ans=0;
    while(N/10){
      if(used.count(N)){
        ans=-1;
        break;
      }
      used.insert(N);
      ans++;
      int max=0;
      for(int p=1;p<N;p*=10){
        if((N/p)*(N%p)>max)max=(N/p)*(N%p);
      }
      N=max;
    }
    cout<<ans<<endl;
  }
}