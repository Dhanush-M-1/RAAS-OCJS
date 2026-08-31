#include <bits/stdc++.h>
using namespace std;
const int m_x[] = {-1, 0, 0, 1};
const int m_y[] = {0, -1, 1, 0};
template <typename T, typename S>
ostream& operator<<(ostream& output, const pair<T, S>& to_print) {
  output << to_print.first << ":" << to_print.second;
  return output;
}
template <typename T, typename S>
ostream& operator<<(ostream& output, const map<T, S>& to_print) {
  for (typename map<T, S>::const_iterator it = to_print.begin();
       it != to_print.end(); it++)
    output << *it << endl;
  return output;
}
template <typename T>
ostream& operator<<(ostream& output, const vector<T>& to_print) {
  for (typename vector<T>::const_iterator it = to_print.begin();
       it != to_print.end(); it++)
    output << *it << " ";
  return output;
}
template <typename T>
ostream& operator<<(ostream& output, const set<T>& to_print) {
  for (typename set<T>::const_iterator it = to_print.begin();
       it != to_print.end(); it++)
    output << *it << " ";
  return output;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int n, m, k;
  cin >> n >> m >> k;
  set<pair<int, int> > sets[4];
  for (int i = 0; i < n; i++) {
    int t, a, b;
    cin >> t >> a >> b;
    if (a == 1 && b == 1)
      sets[0].insert(make_pair(t, i + 1));
    else if (a == 1 && b == 0)
      sets[1].insert(make_pair(t, i + 1));
    else if (a == 0 && b == 1)
      sets[2].insert(make_pair(t, i + 1));
    else
      sets[3].insert(make_pair(t, i + 1));
  }
  {
    bool flag_possible = true;
    int x = sets[0].size(), y = min(sets[1].size(), sets[2].size());
    int no_of_likes = x + y;
    if (no_of_likes < k) flag_possible = false;
    int m_copy = m - x, k_copy = k - x;
    if (k_copy > 0) {
      if (m_copy < 2 * k_copy) flag_possible = false;
    }
    if (!flag_possible) {
      cout << "-1\n";
      return 0;
    }
  }
  vector<pair<int, int> > sol, sol2, sol3;
  int ava = m - k;
  long long ans = 0;
  bool flag_cmp = true, flag_cmp2 = true;
  while (true) {
    if (k == 0) break;
    if (sets[1].size() == 0 || sets[2].size() == 0) flag_cmp2 = false;
    if (sets[0].size() == 0) flag_cmp = false;
    if (flag_cmp && flag_cmp2 && ava) {
      pair<int, int> s1 = *sets[0].begin(), s2 = *sets[1].begin(),
                     s3 = *sets[2].begin();
      if (s1.first <= s2.first + s3.first) {
        sets[0].erase(sets[0].begin());
        ans += s1.first;
        k--;
        m--;
        sol.push_back(s1);
      } else if (s1.first > s2.first + s3.first) {
        sets[1].erase(sets[1].begin());
        sets[2].erase(sets[2].begin());
        ans += s2.first + s3.first;
        k--;
        m -= 2;
        sol2.push_back(s2);
        sol2.push_back(s3);
        ava--;
      }
    } else if (flag_cmp) {
      vector<set<pair<int, int> >::iterator> arr;
      for (set<pair<int, int> >::iterator it = sets[0].begin();
           it != sets[0].end() && k; it++) {
        sol.push_back(*it);
        ans += it->first;
        k--;
        m--;
        arr.push_back(it);
      }
      for (int i = 0; i < arr.size(); i++) sets[0].erase(arr[i]);
      break;
    } else if (flag_cmp2) {
      vector<set<pair<int, int> >::iterator> arr;
      for (set<pair<int, int> >::iterator it = sets[1].begin(),
                                          it2 = sets[2].begin();
           it != sets[1].end() && it2 != sets[2].end() && k; it++, it2++) {
        sol2.push_back(*it);
        sol2.push_back(*it2);
        ans += it->first + it2->first;
        k--;
        m -= 2;
        arr.push_back(it);
        arr.push_back(it2);
      }
      for (int i = 0; i < arr.size(); i++)
        if (i % 2 == 0)
          sets[1].erase(arr[i]);
        else
          sets[2].erase(arr[i]);
      break;
    }
  }
  if (m > 0) {
    set<pair<int, int> >::iterator it[4] = {sets[0].begin(), sets[1].begin(),
                                            sets[2].begin(), sets[3].begin()};
    while (m--) {
      vector<pair<pair<int, int>, int> > to_sort;
      for (int i = 0; i < 4; i++)
        if (it[i] != sets[i].end()) to_sort.push_back(make_pair(*(it[i]), i));
      sort(to_sort.begin(), to_sort.end());
      bool flag = false;
      if (to_sort[0].second == 3 && sol.size() > 0 && it[2] != sets[2].end() &&
          it[1] != sets[1].end()) {
        pair<int, int> last = *(--sol.end()), cur1 = *it[1], cur2 = *it[2];
        if (last.first + to_sort[0].first.first > cur1.first + cur2.first) {
          sol.erase(--sol.end());
          sets[0].insert(last);
          it[0] = sets[0].begin();
          sol2.push_back(cur1);
          sol2.push_back(cur2);
          ans -= last.first;
          ans += cur1.first + cur2.first;
          sets[1].erase(sets[1].begin());
          sets[2].erase(sets[2].begin());
          it[1] = sets[1].begin();
          it[2] = sets[2].begin();
          flag = true;
        }
      }
      if (!flag) {
        int ind = to_sort[0].second;
        sets[ind].erase(sets[ind].begin());
        it[ind] = sets[ind].begin();
        ans += to_sort[0].first.first;
        sol3.push_back(to_sort[0].first);
      }
    }
  }
  cout << ans << "\n";
  for (int i = 0; i < sol.size(); i++) cout << sol[i].second << " ";
  for (int i = 0; i < sol2.size(); i++) cout << sol2[i].second << " ";
  for (int i = 0; i < sol3.size(); i++) cout << sol3[i].second << " ";
  cout << "\n";
  return 0;
}
