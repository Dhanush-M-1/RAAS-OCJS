#include<bits/stdc++.h>
using namespace std;

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int n;
  cin >> n;
  int a, b;
  int d[300005] = {};

  int ma = 0;
  for(int i = 0;i < n;++i){
    cin >> a >> b;
    ++d[a + b];
    ma = max(ma, a + b);
  }

  for(int i = 0;i <= 300000;++i){
    d[i + 1] += (d[i] / 2);
    d[i] %= 2;
  }

  for(int i = 0;i <= 300000;++i){
    if(d[i] == 1){
      cout << i << " 0" << endl;
    }
  }

  return 0;
}

