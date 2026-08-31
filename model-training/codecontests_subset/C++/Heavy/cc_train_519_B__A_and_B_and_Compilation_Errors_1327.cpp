#include <bits/stdc++.h>
using namespace std;
int main() {
  map<long long, long long> error1, error2;
  long long n, a;
  cin >> n;
  for (int j = 1; j <= 3; j++) {
    for (long long i = 1; i <= n; i++) {
      if (j == 1) {
        cin >> a;
        if (error1.find(a) == error1.end())
          error1.insert(pair<long long, long long>(a, 1));
        else
          error1[a]++;
      }
      if (j == 2) {
        cin >> a;
        if (error2.find(a) == error2.end())
          error2.insert(pair<long long, long long>(a, 1));
        else
          error2[a]++;
        if (error1.find(a) != error1.end())
          if (error1[a] == 1)
            error1.erase(a);
          else
            error1[a]--;
      }
      if (j == 3) {
        cin >> a;
        if (error2.find(a) != error2.end())
          if (error2[a] == 1)
            error2.erase(a);
          else
            error2[a]--;
      }
    }
    n--;
  }
  for (auto i = error1.begin(); i != error1.end(); i++) {
    if (i->second != 0) cout << i->first << " ";
  }
  for (auto i = error2.begin(); i != error2.end(); i++) {
    if (i->second != 0) cout << i->first << " ";
  }
}
