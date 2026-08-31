#include <bits/stdc++.h>
using namespace std;
 
int main() {
  int N,M;
  cin >> N >> M;
  vector<int> a(55),b(55),c(55),d(55);
  for(int i=0;i<N;i++){cin >> a[i] >> b[i];}
  for(int i=0;i<M;i++){cin >> c[i] >> d[i];}
  int m,num;
  for(int i=0;i<N;i++){
    m=300000000;
    for(int j=0;j<M;j++){
      if(m>abs(a[i]-c[j])+abs(b[i]-d[j])){
        m=abs(a[i]-c[j])+abs(b[i]-d[j]);
        num=j+1;
      }
    }
    cout << num << endl;
  }
}