#include <bits/stdc++.h>
using namespace std;

int main(){
  int N,M;
  cin >> N >> M;
  int a[N],b[N],c[M],d[M];
  for(int i=0;i<N;i++){
    cin >> a[i] >> b[i];
  }
  for(int i=0;i<M;i++){
    cin >> c[i] >> d[i];
  }
  for(int i=0;i<N;i++){
    int min=1000000000;
    int minp=0;
    for(int j=0;j<M;j++){
      int dis=abs(a[i]-c[j])+abs(b[i]-d[j]);
      if(dis<min){
        min=dis;
        minp=j+1;
      }
    }
    cout << minp << endl;
  }
}

