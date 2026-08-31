#include <bits/stdc++.h>
using namespace std;

int main(){
  int N,M,p,k=INT_MAX;
  cin >> N >> M;
  int a[N],b[N],c[M],d[M],x[N];
  for(int i=0;i<N;i++){
    cin >> a[i] >> b[i];
  }
  for(int i=0;i<M;i++){
    cin >> c[i] >> d[i];
  }
  for(int i=0;i<N;i++){
    for(int j=0;j<M;j++){
      p=(abs(a[i]-c[j]) + abs(b[i]-d[j]));
      if(p < k){
        k=p;
        x[i]=j+1;
      }
    }
    k=INT_MAX;
  }
  for(int i=0;i<N;i++){
    cout << x[i] << endl;
  }
  return 0;
}
