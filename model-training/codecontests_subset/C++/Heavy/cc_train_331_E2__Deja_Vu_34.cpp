#include <bits/stdc++.h>
const int N = 50;
const int MOD = (int)1e9 + 7;
std::vector<int> *graph[N][N], *rgraph[N][N];
std::vector<int> find(std::vector<int> *graph[N][N], std::vector<int> seq,
                      int l) {
  for (int i = 1; i < (int)seq.size() && (int)seq.size() <= l; ++i) {
    std::vector<int> *g = graph[seq[i - 1]][seq[i]];
    if (g == NULL) {
      return std::vector<int>();
    }
    for (int v : *g) {
      seq.push_back(v);
    }
  }
  return seq;
}
std::vector<int> reverse(std::vector<int> seq) {
  std::reverse((seq).begin(), (seq).end());
  return seq;
}
std::vector<int> concat(std::vector<int> a, const std::vector<int> &b) {
  a.insert(a.end(), b.begin(), b.end());
  return a;
}
void update(int &x, int a) {
  x += a;
  if (x >= MOD) {
    x -= MOD;
  }
}
int ways[2 * N + 1][3][N];
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int _ = 0; _ < m; ++_) {
    int x, y, k;
    scanf("%d%d%d", &x, &y, &k);
    x--, y--;
    std::vector<int> seq;
    while (k--) {
      int v;
      scanf("%d", &v);
      seq.push_back(--v);
    }
    graph[x][y] = new std::vector<int>(seq);
    rgraph[y][x] = new std::vector<int>(reverse(seq));
  }
  std::vector<std::vector<int> > seqs[3];
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      if (graph[i][j] != NULL) {
        std::vector<int> seq = *graph[i][j];
        if (!seq.empty() && seq.back() == i) {
          const auto &path = reverse(find(rgraph, reverse(seq), 2 * n));
          if (1 <= (int)path.size() && path.size() <= 2 * n) {
            seqs[0].push_back(concat(path, std::vector<int>(1, j)));
          }
        }
        for (int k = 1; k < (int)seq.size(); ++k) {
          if (seq[k - 1] == i && seq[k] == j) {
            const auto &bpath = reverse(find(
                rgraph, reverse(std::vector<int>(seq.begin(), seq.begin() + k)),
                2 * n));
            const auto &fpath = find(
                graph, std::vector<int>(seq.begin() + k, seq.end()), 2 * n);
            if (!bpath.empty() && !fpath.empty() &&
                bpath.size() + fpath.size() <= 2 * n) {
              seqs[1].push_back(concat(bpath, fpath));
            }
          }
        }
        if (!seq.empty() && seq.front() == j) {
          const auto &path = find(graph, seq, 2 * n);
          if (1 <= (int)path.size() && path.size() <= 2 * n) {
            seqs[2].push_back(concat(std::vector<int>(1, i), path));
          }
        }
      }
    }
  }
  for (int i = 0; i < 3; ++i) {
    std::sort((seqs[i]).begin(), (seqs[i]).end());
    seqs[i].erase(std::unique((seqs[i]).begin(), (seqs[i]).end()),
                  seqs[i].end());
  }
  memset(ways, 0, sizeof(ways));
  for (int v = 0; v < n; ++v) {
    ways[0][0][v] = ways[0][1][v] = 1;
  }
  for (int i = 0; i <= 2 * n; ++i) {
    for (int s = 0; s < 3; ++s) {
      for (const std::vector<int> &seq : seqs[s]) {
        int u = seq.front();
        int v = seq.back();
        int j = i + seq.size() - 1;
        if (j <= 2 * n) {
          if (s != 1) {
            update(ways[j][s][v], ways[i][s][u]);
          }
          if (s != 2) {
            update(ways[j][s + 1][v], ways[i][0][u]);
          }
        }
      }
    }
    if (i + 1 <= 2 * n) {
      for (int j = 0; j < n; ++j) {
        for (int k = 0; k < n; ++k) {
          std::vector<int> *seq = graph[j][k];
          if (seq != NULL && seq->empty()) {
            update(ways[i + 1][0][k], ways[i][2][j]);
            update(ways[i + 1][1][k], ways[i][2][j]);
          }
        }
      }
    }
    if (i) {
      int result = 0;
      for (int v = 0; v < n; ++v) {
        update(result, ways[i][2][v]);
      }
      printf("%d\n", result);
    }
  }
  return 0;
}
