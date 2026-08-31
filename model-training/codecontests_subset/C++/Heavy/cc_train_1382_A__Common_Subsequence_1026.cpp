#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t;
  cin >> t;
  while (t--) {
    long long int n, m;
    cin >> n >> m;
    long long int arr1[n];
    long long int arr2[m];
    for (long long int i = 0; i < n; i++) {
      cin >> arr1[i];
    }
    for (long long int i = 0; i < m; i++) {
      cin >> arr2[i];
    }
    set<long long int> st;
    for (long long int i = 0; i < n; i++) {
      st.insert(arr1[i]);
    }
    long long int flag = 0, v;
    for (long long int i = 0; i < m; i++) {
      if (st.find(arr2[i]) != st.end()) {
        flag = 1;
        v = arr2[i];
        break;
      }
    }
    if (flag == 1) {
      cout << "YES" << endl;
      cout << 1 << " " << v << endl;
    } else {
      cout << "NO" << endl;
    }
  }
}
