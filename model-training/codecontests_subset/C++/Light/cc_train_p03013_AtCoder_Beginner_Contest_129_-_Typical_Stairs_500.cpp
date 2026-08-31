#include<bits/stdc++.h>
using namespace std;
int main(){
  int inf=1000000007;
  int n,m;
  cin >> n >> m;
  int a;
  cin >> a;
  vector<int> step(n+1);
  step[0] = 1;
  if(a != 1)step[1] = 1;
  else cin >> a;
  for(int i=2; i<=n; i++){
    if(a == i){
      cin >> a;
      continue;
    }
    step[i] = (step[i-1] + step[i-2])%inf;
  }
  cout << step[n]%inf;
}