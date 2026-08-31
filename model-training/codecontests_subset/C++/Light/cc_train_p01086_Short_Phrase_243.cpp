#include <bits/stdc++.h>
using namespace std;
vector<int> cnt = {5, 12, 17, 24, 31};
int main(){
  while (1){
    int n;
    cin >> n;
    if (n == 0){
      break;
    }
    vector<string> w(n);
    for (int i = 0; i < n; i++){
      cin >> w[i];
    }
    vector<int> sum(n + 1, 0);
    for (int i = 0; i < n; i++){
      sum[i + 1] = sum[i] + w[i].size();
    }
    set<int> st;
    for (int i = 0; i <= n; i++){
      st.insert(sum[i]);
    }
    for (int i = 0; i < n; i++){
      bool ok = true;
      for (int j = 0; j < 5; j++){
        if (!st.count(sum[i] + cnt[j])){
          ok = false;
        }
      }
      if (ok){
        cout << i + 1 << endl;
        break;
      }
    }
  }
}
