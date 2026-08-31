#include <bits/stdc++.h>
using namespace std;
void scan() {}
template <class T, class... A>
void scan(T& t, A&... a) {
  cin >> t, scan(a...);
}
void print() {}
template <class T, class... A>
void print(T t, A... a) {
  cout << t, print(a...);
}
const int MV = 2e5;
int n, m, k, ans = INT_MAX, idx, posTake, posRem;
vector<pair<int, int> > alice, bob, both, none, merged;
vector<int> ai, bi;
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  scan(n, m, k);
  alice.push_back({0, 0});
  bob.push_back({0, 0});
  both.push_back({0, 0});
  none.push_back({0, 0});
  for (int i = 1, t, a, b; i <= n; i++) {
    scan(t, a, b);
    if (a && b)
      both.push_back({t, i});
    else if (a)
      alice.push_back({t, i});
    else if (b)
      bob.push_back({t, i});
    else
      none.push_back({t, i});
  }
  sort(both.begin(), both.end());
  sort(alice.begin(), alice.end());
  sort(bob.begin(), bob.end());
  sort(none.begin(), none.end());
  int a = 1, b = 1, c = 1;
  merged.push_back({0, 0});
  ai.push_back(0);
  bi.push_back(0);
  bob.push_back({INT_MAX, 0});
  alice.push_back({INT_MAX, 0});
  none.push_back({INT_MAX, 0});
  while (true) {
    if (a == (int)alice.size() - 1 && b == (int)bob.size() - 1 &&
        c == (int)none.size() - 1)
      break;
    if (bob[b].first <= alice[a].first && bob[b].first <= none[c].first) {
      merged.push_back({bob[b].first, bob[b].second});
      bi.push_back(bi[(int)bi.size() - 1] + 1);
      ai.push_back(ai[(int)ai.size() - 1]);
      b++;
    } else if (alice[a].first <= bob[b].first &&
               alice[a].first <= none[c].first) {
      merged.push_back({alice[a].first, alice[a].second});
      bi.push_back(bi[(int)bi.size() - 1]);
      ai.push_back(ai[(int)ai.size() - 1] + 1);
      a++;
    } else {
      merged.push_back({none[c].first, none[c].second});
      bi.push_back(bi[(int)bi.size() - 1]);
      ai.push_back(ai[(int)ai.size() - 1]);
      c++;
    }
  }
  bob.pop_back();
  alice.pop_back();
  for (int i = 1; i < (int)both.size(); i++) both[i].first += both[i - 1].first;
  for (int i = 1; i < (int)alice.size(); i++)
    alice[i].first += alice[i - 1].first;
  for (int i = 1; i < (int)bob.size(); i++) bob[i].first += bob[i - 1].first;
  for (int i = 1; i < (int)merged.size(); i++)
    merged[i].first += merged[i - 1].first;
  for (int i = 0; i < min(m + 1, (int)both.size()); i++) {
    int take = max(0, k - i), rem = m - i - 2 * take;
    if ((int)bob.size() - 1 < k - i || (int)alice.size() - 1 < k - i || rem < 0)
      continue;
    int low = 0, high = (int)merged.size() - 1, target = -1;
    while (low <= high) {
      int mid = (low + high) / 2,
          cnt = mid - min(ai[mid], take) - min(bi[mid], take);
      if (cnt == rem) {
        target = mid;
        break;
      } else if (cnt < rem)
        low = mid + 1;
      else
        high = mid - 1;
    }
    if (target != -1) {
      int sum = both[i].first + bob[take].first + alice[take].first +
                merged[target].first - bob[min(bi[target], take)].first -
                alice[min(ai[target], take)].first;
      if (ans > sum) {
        ans = sum;
        idx = i;
        posTake = take;
        posRem = target;
      }
    }
  }
  if (ans == INT_MAX)
    print(-1);
  else {
    print(ans, '\n');
    set<int> s;
    for (int i = 1; i <= idx; i++) print(both[i].second, ' ');
    for (int i = 1; i <= posTake; i++) {
      s.insert(alice[i].second);
      s.insert(bob[i].second);
    }
    for (int i = 1; i <= posRem; i++) {
      s.insert(merged[i].second);
    }
    for (int i : s) print(i, ' ');
  }
}
