#include <bits/stdc++.h>
using namespace std;
bool comp(pair<int, pair<int, int> > a, pair<int, pair<int, int> > b) {
  return a.first < b.first;
}
int main() {
  int n, k;
  cin >> n >> k;
  vector<pair<int, pair<int, int> > > book;
  for (int i = 0; i < n; i++) {
    pair<int, pair<int, int> > temp;
    cin >> temp.first >> temp.second.first >> temp.second.second;
    book.push_back(temp);
  }
  stack<int> alice, bob, both;
  sort(book.begin(), book.end(), comp);
  for (int i = 0; i < n; i++) {
    int t = book[i].first;
    bool a = book[i].second.first;
    bool b = book[i].second.second;
    if (a && b) {
      int t1 = 0, t2 = 0;
      if (!alice.empty()) {
        t1 = alice.top();
      }
      if (!bob.empty()) {
        t2 = bob.top();
      }
      if (t1 + t2 >= t) {
        both.push(t);
        if (alice.size() + both.size() > k) {
          alice.pop();
        }
        if (bob.size() + both.size() > k) {
          bob.pop();
        }
      } else {
        if (alice.size() + bob.size() + 2 * both.size() < 2 * k) {
          both.push(t);
        }
        if (alice.size() + both.size() > k) {
          alice.pop();
        }
        if (bob.size() + both.size() > k) {
          bob.pop();
        }
      }
    } else if (a) {
      if (alice.size() + both.size() < k) {
        alice.push(t);
      }
    } else if (b) {
      if (bob.size() + both.size() < k) {
        bob.push(t);
      }
    }
  }
  if (alice.size() + bob.size() + 2 * both.size() < 2 * k) {
    cout << -1 << endl;
  } else {
    int ans = 0;
    while (!alice.empty()) {
      ans += alice.top();
      alice.pop();
    }
    while (!bob.empty()) {
      ans += bob.top();
      bob.pop();
    }
    while (!both.empty()) {
      ans += both.top();
      both.pop();
    }
    cout << ans << endl;
  }
}
