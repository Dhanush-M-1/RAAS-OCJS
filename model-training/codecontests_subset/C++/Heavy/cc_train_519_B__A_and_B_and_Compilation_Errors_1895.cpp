#include <bits/stdc++.h>
using namespace std;
multiset<int> rec, tem;
int main() {
  std::chrono::time_point<std::chrono::high_resolution_clock> start, end;
  start = std::chrono::high_resolution_clock::now();
  int n, ans1, ans2;
  cin >> n;
  for (int(i) = (0); (i) < (n); ++(i)) {
    int c;
    cin >> c;
    rec.insert(c);
    tem.insert(c);
  }
  for (int(i) = (0); (i) < (n - 1); ++(i)) {
    int c;
    cin >> c;
    auto it = rec.find(c);
    rec.erase(it);
  }
  ans1 = *rec.begin();
  auto it = tem.find(ans1);
  tem.erase(it);
  for (int(i) = (0); (i) < (n - 2); ++(i)) {
    int c;
    cin >> c;
    auto it = tem.find(c);
    tem.erase(it);
  }
  ans2 = *tem.begin();
  cout << ans1 << endl << ans2 << endl;
  end = std::chrono::high_resolution_clock::now();
  long long elapsed_time =
      std::chrono::duration_cast<std::chrono::milliseconds>(end - start)
          .count();
  return 0;
}
