#include <bits/stdc++.h>
using namespace std;
template <class T>
void Output(const T& v, bool print_new_line = true) {
  bool first = true;
  for (auto element : v) {
    if (!first)
      cout << " ";
    else
      first = false;
    cout << element;
  }
  if (print_new_line) cout << endl;
}
template <class T>
void Input(vector<T>& v, int n) {
  v.resize(n);
  for (int i = 0; i < n; ++i) {
    cin >> v[i];
  }
}
template <class T>
vector<int> Query(const T& c, int answer_counts) {
  cout << "? " << c.size();
  for (auto it = c.begin(); it != c.end(); ++it) {
    cout << " " << (*it);
  }
  cout << endl;
  cout.flush();
  vector<int> s(answer_counts);
  for (int i = 0; i < answer_counts; ++i) {
    cin >> s[i];
  }
  return s;
}
inline int get(int k, const vector<int>& v) {
  if (k <= 0) return 0;
  return v[k - 1];
}
struct Book {
  int t, a, b, id;
};
struct compare {
  bool operator()(const Book& a, const Book& b) {
    return a.t < b.t || (a.t == b.t && a.id < b.id);
  }
};
int init(int k, int m, int both, vector<vector<list<Book>>> bs,
         set<Book, compare>& a, set<Book, compare>& b,
         set<Book, compare>& rest) {
  a.clear();
  b.clear();
  rest.clear();
  int total = 0;
  while ((int)a.size() < k - both && !bs[1][0].empty()) {
    total += bs[1][0].front().t;
    a.insert(bs[1][0].front());
    bs[1][0].pop_front();
  }
  while ((int)b.size() < k - both && !bs[0][1].empty()) {
    total += bs[0][1].front().t;
    b.insert(bs[0][1].front());
    bs[0][1].pop_front();
  }
  std::copy(bs[1][0].begin(), bs[1][0].end(), inserter(rest, rest.begin()));
  std::copy(bs[0][1].begin(), bs[0][1].end(), inserter(rest, rest.begin()));
  std::copy(bs[0][0].begin(), bs[0][0].end(), inserter(rest, rest.begin()));
  while (rest.size() > 0 &&
         (int)(rest.size() + a.size() + b.size()) > m - both) {
    auto it = rest.end();
    --it;
    rest.erase(it);
  }
  return total + std::accumulate(rest.begin(), rest.end(), 0,
                                 [](int v, const Book& b) { return v + b.t; });
}
int main() {
  int n, m, k;
  cin >> n >> m >> k;
  vector<Book> books(n);
  for (int i = 0; i < n; ++i) {
    cin >> books[i].t >> books[i].a >> books[i].b;
    books[i].id = i + 1;
  }
  sort(books.begin(), books.end(),
       [](const Book& a, const Book& b) { return a.t < b.t; });
  vector<vector<list<Book>>> bs(2);
  bs[0].resize(2);
  bs[1].resize(2);
  for (int i = 0; i < n; ++i) {
    bs[books[i].a][books[i].b].push_back(books[i]);
  }
  int best = 0x7FFFFFFF;
  int best_i = -1;
  bool inited = false;
  int idx[2][2] = {0};
  set<Book, compare> both, a, b, rest;
  int total = 0;
  auto iter = bs[1][1].begin();
  set<Book, compare> rest_no;
  for (int i = 0; i <= bs[1][1].size() && i <= m; ++i) {
    if (!inited) {
      total = init(k, m, i, bs, a, b, rest);
      for (auto book : bs[0][0]) {
        if (rest.find(book) == rest.end()) {
          rest_no.insert(book);
        }
      }
      inited = true;
    }
    while ((int)a.size() > k - i && !a.empty()) {
      auto it = a.end();
      --it;
      rest.insert(*it);
      a.erase(it);
    }
    while ((int)b.size() > k - i && !b.empty()) {
      auto it = b.end();
      --it;
      rest.insert(*it);
      b.erase(it);
    }
    while ((int)(rest.size() + a.size() + b.size()) > m - i && !rest.empty()) {
      auto it = rest.end();
      --it;
      total -= it->t;
      rest_no.insert(*it);
      rest.erase(it);
    }
    while (!rest_no.empty() && !rest.empty() &&
           rest.rbegin()->t > rest_no.begin()->t) {
      auto it = rest.end();
      --it;
      total -= it->t;
      rest.erase(it);
      rest.insert(*rest_no.begin());
      total += rest_no.begin()->t;
      rest_no.erase(rest_no.begin());
    }
    if ((int)a.size() >= k - i && (int)b.size() >= k - i &&
        (int)(a.size() + b.size() + rest.size()) == m - i) {
      if (total < best) {
        best = total;
        best_i = i;
      }
    }
    if (iter != bs[1][1].end()) {
      total += iter->t;
      ++iter;
    }
  }
  if (best_i == -1) {
    cout << -1 << endl;
    return 0;
  }
  cout << best << endl;
  init(k, m, best_i, bs, a, b, rest);
  iter = bs[1][1].begin();
  while (best_i-- > 0) {
    cout << iter->id << " ";
    ++iter;
  }
  std::for_each(a.begin(), a.end(), [](const Book& v) { cout << v.id << " "; });
  std::for_each(b.begin(), b.end(), [](const Book& v) { cout << v.id << " "; });
  std::for_each(rest.begin(), rest.end(),
                [](const Book& v) { cout << v.id << " "; });
  cout << endl;
  return 0;
}
