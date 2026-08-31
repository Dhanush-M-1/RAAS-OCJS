#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<pair<int, int> > trees(n);
  for (int i = 0; i < n; i++) {
    cin >> trees[i].first >> trees[i].second;
  }
  if (n == 1) {
    cout << "1\n";
    return 0;
  }
  int count = 2;
  int reference = trees[0].first;
  for (int i = 1; i < n - 1; i++) {
    if (trees[i].first - trees[i].second > reference) {
      reference = trees[i].first;
      count++;
    } else if (trees[i].first + trees[i].second < trees[i + 1].first) {
      count++;
      reference = trees[i].first + trees[i].second;
    } else {
      reference = trees[i].first;
    }
  }
  cout << count << "\n";
}
