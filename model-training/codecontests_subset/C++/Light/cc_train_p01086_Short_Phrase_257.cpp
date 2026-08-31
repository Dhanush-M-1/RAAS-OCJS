#include <bits/stdc++.h>
using namespace std;

int main() {
  int n;

  while (cin >> n, n) {
    vector<string> s;
    for (int i = 0; i < n; ++i) {
      string in;
      cin >> in;
      s.push_back(in);
    }

    for (int i = 0; i < s.size(); ++i) {

      int length = 0;
      int cnt = 0;

      for (int j = i; j < s.size() && cnt != 5; ++j) {
        length += s[j].size();

        if ((cnt == 0 || cnt == 2) && length == 5) {
          length = 0;
          cnt++;
          continue;
        }
        if ((cnt == 1 || cnt == 3 || cnt == 4) && length == 7) {
          length = 0;
          cnt++;
          continue;
        }
      }

      if (cnt == 5) {
        cout << i + 1 << endl;
        break;
      }
    }
  }
}