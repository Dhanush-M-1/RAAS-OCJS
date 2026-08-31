#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  map<int, int> arr;
  map<int, int> st;
  for (int i = 0; i < n; ++i) {
    int a;
    cin >> a;
    arr[a]++;
    st[a]++;
  }
  for (int i = 0; i < n - 1; ++i) {
    int a;
    cin >> a;
    arr[a]--;
  }
  for (map<int, int>::iterator it = st.begin(); it != st.end(); ++it) {
    if (arr[it->first] > 0) {
      cout << it->first << endl;
      arr[it->first] = st[it->first] - 1;
      it->second = st[it->first] - 1;
    } else {
      arr[it->first] = st[it->first];
    }
  }
  for (int i = 0; i < n - 2; ++i) {
    int a;
    cin >> a;
    arr[a]--;
  }
  for (map<int, int>::iterator it = st.begin(); it != st.end(); ++it) {
    if (arr[it->first] > 0) {
      cout << it->first << endl;
      break;
    }
  }
  return 0;
}
