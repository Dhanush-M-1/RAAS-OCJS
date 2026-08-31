#include <bits/stdc++.h>
using namespace std;
const int INF = 1000 * 1000 * 1000 + 7;
const double EPS = 1e-9;
int bit_count(int first) {
  return first == 0 ? 0 : 1 + bit_count(first & (first - 1));
}
inline int last_bit(int first) { return first & -first; }
inline int sign(double first) {
  return first < -EPS ? -1 : first > EPS ? 1 : 0;
}
inline int sign(int first) { return (first > 0) - (first < 0); }
int nextComb(int first) {
  int smallest = first & -first;
  int ripple = first + smallest;
  int ones = first ^ ripple;
  ones = (ones >> 2) / smallest;
  return ripple | ones;
}
int gcd(int a, int b) {
  while (b) {
    int r = a % b;
    a = b;
    b = r;
  }
  return a;
}
int lcm(int a, int b) { return a / gcd(a, b) * b; }
struct UnionFind {
  vector<int> P, S, R;
  UnionFind(int n)
      : P(vector<int>(n)), S(vector<int>(n, 1)), R(vector<int>(n, 1)) {
    for (int i = (int)0; i < (int)n; ++i) P[i] = i;
  }
  int findP(int first) {
    if (P[first] != first) P[first] = findP(P[first]);
    return P[first];
  }
  inline int operator[](const int first) { return findP(first); }
  int merge(int a, int b) {
    int pa = findP(a), push_back = findP(b);
    if (pa == push_back) return 0;
    if (R[pa] < R[push_back]) {
      P[pa] = push_back;
      S[push_back] += S[pa];
    } else {
      P[push_back] = pa;
      S[pa] += S[push_back];
    }
    if (R[pa] == R[push_back]) ++R[pa];
    return 1;
  }
};
const int BUF_SIZE = 201;
char buf[BUF_SIZE];
inline string getToken() {
  scanf("%s", buf);
  return buf;
}
inline string getLine() {
  fgets(buf, BUF_SIZE, stdin);
  return buf;
}
inline int getInt() {
  int a;
  scanf("%d", &a);
  return a;
}
inline double getDouble() {
  double a;
  scanf("%lf", &a);
  return a;
}
inline int stoi(string first) {
  stringstream ss;
  int ret;
  ss << first;
  ss >> ret;
  return ret;
}
inline vector<string> split(string &s) {
  stringstream ss;
  ss << s;
  string t;
  vector<string> ret;
  while (ss >> t) ret.push_back(t);
  return ret;
}
template <class K, class V>
vector<K> getKeys(map<K, V> m) {
  vector<K> keys;
  for (typeof((m).begin()) it = (m).begin(); it != (m).end(); ++it)
    keys.push_back(it->first);
  return keys;
}
inline double myRand() {
  return ((double)rand() / RAND_MAX) + ((double)rand() / RAND_MAX / RAND_MAX);
}
void myCode() {
  int t = getInt();
  int m = getInt();
  vector<bool> mem;
  for (int i = (int)0; i < (int)m; ++i) mem.push_back(false);
  vector<pair<int, int> > blocks;
  while (t--) {
    string s = getToken();
    if (s == "alloc") {
      bool success = false;
      int n = getInt();
      int i = 0;
      while (!success && i <= m - n) {
        int j = 0;
        while (j < n && !mem[i + j]) j++;
        fprintf(stderr, "found %d empty blocks starting from %d\n", j, i);
        if (j == n) success = true;
        if (!success) i += (j + 1);
      }
      if (success) {
        for (int j = (int)0; j < (int)n; ++j) mem[i + j] = true;
        blocks.push_back(pair<int, int>(i, n));
        fprintf(stderr,
                "successfully allocated a block of size %d starting at address "
                "%d\n",
                n, i);
        printf("%d\n", ((int)(blocks).size()));
      } else
        printf("NULL\n");
    } else if (s == "erase") {
      int n = getInt() - 1;
      if (n < 0 || n >= ((int)(blocks).size())) {
        printf("ILLEGAL_ERASE_ARGUMENT\n");
        fprintf(stderr, "ERASE FAIL\n");
      } else {
        fprintf(stderr, "erasing block %d, starting at %d and of length %d\n",
                n + 1, blocks[n].first, blocks[n].second);
        if (blocks[n].second == 0) {
          printf("ILLEGAL_ERASE_ARGUMENT\n");
          fprintf(stderr, "ERASE FAIL\n");
        }
        for (int i = (int)0; i < (int)blocks[n].second; ++i)
          mem[blocks[n].first + i] = false;
        blocks[n].second = 0;
      }
    } else if (s == "defragment") {
      int start = 0;
      vector<pair<pair<int, int>, int> > blox;
      for (int i = (int)0; i < (int)((int)(blocks).size()); ++i) {
        blox.push_back(make_pair(blocks[i], i));
      }
      sort((blox).begin(), (blox).end());
      for (int i = (int)0; i < (int)((int)(blox).size()); ++i) {
        for (int j = (int)0; j < (int)blox[i].first.second; ++j)
          mem[start + j] = true;
        blocks[blox[i].second].first = start;
        start += blox[i].first.second;
      }
      for (int i = (int)start; i < (int)m; ++i) mem[i] = false;
    }
    for (int i = (int)0; i < (int)m; ++i)
      fprintf(stderr, "%d ", (mem[i] == true));
    fprintf(stderr, "\n");
    for (int i = (int)0; i < (int)((int)(blocks).size()); ++i)
      fprintf(stderr, "block %d: starting at %d and of length %d\n", i + 1,
              blocks[i].first, blocks[i].second);
    fprintf(stderr, "\n");
  }
}
int main() {
  srand(time(NULL));
  myCode();
  return 0;
}
