#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1000000007;

int main() {
  int N,M;
  cin >> N >> M;
  int f[N+1];
  for(int i=0;i<N+1;i++) f[i]=1;
  for(int i=0;i<M;i++){
    int a; cin >> a; f[a]=0;
  }
  long long s[N+1];
  s[0]=1;
  s[1]=f[1];
  for(int i=2;i<N+1;i++){
    s[i] = ((s[i-1]+s[i-2])*f[i])%MOD;
  }
  cout << s[N] << endl;
  return 0;
}