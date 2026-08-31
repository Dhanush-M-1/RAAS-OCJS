#include <bits/stdc++.h>
#include <math.h>
using namespace std;
int main() {
  int N,M,x,ans,ans2;
  cin>>N>>M;
  int a[N],b[N],c[M],d[M];
  for(int i=0;i<N;i++) cin>>a[i]>>b[i];
  for(int i=0;i<M;i++) cin>>c[i]>>d[i];
  
  for(int i=0;i<N;i++){
    for(int j=0;j<M;j++){
    	x=abs(a[i]-c[j])+abs(b[i]-d[j]);
      	if(j==0){
          ans=x;
          ans2=j+1;
        }
      	if(x<ans){
          ans=x;
     	  ans2=j+1;
        }
    }
    cout<<ans2<<endl;
  }
}
