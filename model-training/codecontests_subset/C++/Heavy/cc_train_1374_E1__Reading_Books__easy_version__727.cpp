#include <bits/stdc++.h>
const long long INF = 1000000000000000001;
using namespace std;
mt19937 random1(179);
struct Node {
  Node* l;
  Node* r;
  long long x, y, sum1, num, len;
  Node(long long x1)
      : x(x1), y(random1()), l(nullptr), r(nullptr), sum1(x1), num(1), len(1) {}
};
void update(Node* tree) {
  if (tree == nullptr) {
    return;
  }
  tree->sum1 = tree->x * tree->num, tree->len = tree->num;
  if (tree->l != nullptr) {
    tree->sum1 += tree->l->sum1, tree->len += tree->l->len;
  }
  if (tree->r != nullptr) {
    tree->sum1 += tree->r->sum1, tree->len += tree->r->len;
  }
}
Node* merge(Node* tree1, Node* tree2) {
  if (tree1 == nullptr) {
    return tree2;
  }
  if (tree2 == nullptr) {
    return tree1;
  }
  if (tree1->y < tree2->y) {
    tree1->r = merge(tree1->r, tree2);
    update(tree1);
    return tree1;
  } else {
    tree2->l = merge(tree1, tree2->l);
    update(tree2);
    return tree2;
  }
}
pair<Node*, Node*> split(Node* tree, long long x) {
  if (tree == nullptr) {
    return {nullptr, nullptr};
  }
  if (x == tree->x) {
    Node* right = tree->r;
    tree->r = nullptr;
    update(tree);
    return {tree, right};
  } else if (x < tree->x) {
    pair<Node*, Node*> tree1 = split(tree->l, x);
    tree->l = nullptr;
    update(tree);
    return {tree1.first, merge(tree1.second, tree)};
  } else {
    pair<Node*, Node*> tree1 = split(tree->r, x);
    tree->r = nullptr;
    update(tree);
    return {merge(tree, tree1.first), tree1.second};
  }
}
long long sum_k(Node* tree, long long k) {
  if (tree == nullptr) {
    return 0;
  }
  long long now = (tree->l == nullptr ? 0 : tree->l->len),
            sum1 = (tree->l == nullptr ? 0 : tree->l->sum1);
  if (now <= k && now + tree->num >= k) {
    return sum1 + tree->x * (k - now);
  } else if (now < k) {
    return sum_k(tree->r, k - now - tree->num) + sum1 + tree->x * tree->num;
  } else {
    return sum_k(tree->l, k);
  }
}
Node* add(Node* tree, long long x) {
  pair<Node*, Node*> tree1 = split(tree, x);
  pair<Node*, Node*> tree2 = split(tree1.first, x - 1);
  if (tree2.second == nullptr) {
    Node* root = new Node(x);
    return merge(merge(tree2.first, root), tree1.second);
  } else {
    tree2.second->num++;
    update(tree2.second);
    return merge(merge(tree2.first, tree2.second), tree1.second);
  }
}
Node* del(Node* tree, long long x) {
  pair<Node*, Node*> tree1 = split(tree, x);
  pair<Node*, Node*> tree2 = split(tree1.first, x - 1);
  if (tree2.second == nullptr || tree2.second->num == 1) {
    return merge(tree2.first, tree1.second);
  } else {
    tree2.second->num--;
    update(tree2.second);
    return merge(merge(tree2.first, tree2.second), tree1.second);
  }
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  long long n, m, k;
  cin >> n >> m >> k;
  vector<pair<long long, long long> > s00, s01, s10, s11;
  vector<long long> pref01 = {0}, pref10 = {0}, pref11 = {0};
  for (long long q = 0; q < n; q++) {
    long long t, x, y;
    cin >> t >> x >> y;
    if (x == 0 && y == 0) {
      s00.push_back({t, q});
    } else if (x == 0) {
      s01.push_back({t, q});
    } else if (y == 0) {
      s10.push_back({t, q});
    } else {
      s11.push_back({t, q});
    }
  }
  sort(s00.begin(), s00.end());
  sort(s01.begin(), s01.end());
  sort(s10.begin(), s10.end());
  sort(s11.begin(), s11.end());
  Node* DD = nullptr;
  for (pair<long long, long long> q : s00) {
    DD = add(DD, q.first);
  }
  for (pair<long long, long long> q : s01) {
    pref01.push_back(pref01.back() + q.first);
    DD = add(DD, q.first);
  }
  for (pair<long long, long long> q : s10) {
    pref10.push_back(pref10.back() + q.first);
    DD = add(DD, q.first);
  }
  for (pair<long long, long long> q : s11) {
    pref11.push_back(pref11.back() + q.first);
  }
  long long ans = INF, ind = -1;
  for (long long q1 = m; q1 > -1; q1--) {
    if (q1 <= s11.size() &&
        ((DD != nullptr && DD->len >= m - q1 - 2 * max(0LL, k - q1)) ||
         m == q1 + 2 * max(0LL, k - q1)) &&
        m >= q1 + 2 * max(0LL, k - q1)) {
      long long w = pref11[q1] + pref01[max(0LL, k - q1)] +
                    pref10[max(0LL, k - q1)] +
                    sum_k(DD, m - q1 - 2 * max(0LL, k - q1));
      if (w < ans) {
        ans = w, ind = q1;
      }
    }
    if (k - q1 + 1 > min(s01.size(), s10.size())) {
      break;
    }
    if (q1 <= k) {
      DD = del(DD, s01[k - q1].first);
      DD = del(DD, s10[k - q1].first);
    }
  }
  if (ans == INF) {
    cout << -1 << '\n';
  } else {
    cout << ans << '\n';
    for (long long q = 0; q < ind; q++) {
      cout << s11[q].second + 1 << ' ';
    }
    for (long long q = 0; q < max(0LL, k - ind); q++) {
      cout << s01[q].second + 1 << ' ' << s10[q].second + 1 << ' ';
    }
    long long q00 = 0, q01 = max(0LL, k - ind), q10 = max(0LL, k - ind);
    for (long long q = 0; q < m - ind - 2 * max(0LL, k - ind); q++) {
      if (q00 != s00.size() &&
          (q01 == s01.size() || s01[q01].first >= s00[q00].first) &&
          (q10 == s10.size() || s10[q10].first >= s00[q00].first)) {
        cout << s00[q00++].second + 1 << ' ';
      } else if (q01 != s01.size() &&
                 (q00 == s00.size() || s00[q00].first >= s01[q01].first) &&
                 (q10 == s10.size() || s10[q10].first >= s01[q01].first)) {
        cout << s01[q01++].second + 1 << ' ';
      } else {
        cout << s10[q10++].second + 1 << ' ';
      }
    }
    cout << '\n';
  }
  return 0;
}
