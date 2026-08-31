#include <bits/stdc++.h>
int N;
std::map<int, std::pair<long long, long long> > A[100];
void read(std::map<int, std::pair<long long, long long> > &M) {
  int x, y;
  scanf("%d%d", &x, &y);
  for (int i = 2; i * i <= x; i++)
    if (x % i == 0) {
      int count = 0;
      do x /= i, count++;
      while (x % i == 0);
      M[i].first += count;
    }
  if (x > 1) M[x].first++;
  for (int i = 2; i * i <= y; i++)
    if (y % i == 0) {
      int count = 0;
      do y /= i, count++;
      while (y % i == 0);
      M[i].second += count;
    }
  if (y > 1) M[y].second++;
}
long long gcd(long long x, long long y) {
  if (x < 0) x = -x;
  if (y < 0) y = -y;
  long long r;
  while (y) {
    r = x % y;
    x = y;
    y = r;
  }
  return x;
}
long long MUL(long long a, long long b, long long c) {
  long long r = 0;
  for (; b; b >>= 1) {
    if (b & 1) r = r + a < c ? r + a : r + a - c;
    a = a + a < c ? a + a : a + a - c;
  }
  return r;
}
long long POWER(long long a, long long b, long long c) {
  long long r = 1;
  for (; b; b >>= 1) {
    if (b & 1) r = MUL(r, a, c);
    a = MUL(a, a, c);
  }
  return r;
}
long long phi(long long x) {
  long long r = x;
  for (long long i = 2; i * i <= x; i++)
    if (x % i == 0) {
      do x /= i;
      while (x % i == 0);
      r = r / i * (i - 1);
    }
  if (x > 1) r = r / x * (x - 1);
  return r;
}
long long first(long long a, long long b, long long c) {
  if (a == 0) return 0;
  if (b == 0) return c / a;
  long long ta = MUL(POWER(a, phi(-b) - 1, -b), (c % -b + -b) % -b, -b),
            tb = (c - ta * a) / b;
  if (tb < 0) {
    long long D = (-tb + a - 1) / a;
    ta += -b * D;
    tb += a * D;
  }
  return ta;
}
std::map<int, std::pair<long long, long long> > merge(
    std::map<int, std::pair<long long, long long> > a,
    std::map<int, std::pair<long long, long long> > b) {
  for (auto &i : a) b[i.first];
  for (auto &i : b) a[i.first];
  long long line = 0, line_a = 0, line_b = 0, line_c = 0;
  long long point = 0, point_x = 0, point_y = 0;
  for (auto &i : a) {
    std::pair<long long, long long> &pa = i.second, &pb = b[i.first];
    long long A = pa.second, B = -pb.second, C = pb.first - pa.first,
              G = gcd(A, B);
    if (A == 0 && B == 0) {
      if (C) {
        puts("-1");
        exit(0);
      }
      continue;
    }
    if (C % G) {
      puts("-1");
      exit(0);
    }
    A /= G;
    B /= G;
    C /= G;
    if (A < 0 || A == 0 && B < 0) {
      A = -A;
      B = -B;
      C = -C;
    }
    if (point) {
      if (point_x * A + point_y * B != C) {
        puts("-1");
        exit(0);
      }
    } else if (line) {
      if (line_a == A && line_b == B) {
        if (line_c != C) {
          puts("-1");
          exit(0);
        }
      } else {
        long long X0 = A * line_b - line_a * B, X1 = C * line_b - line_c * B,
                  Y0 = B * line_a - line_b * A, Y1 = C * line_a - line_c * A;
        if (X1 % X0 || Y1 % Y0) {
          puts("-1");
          exit(0);
        }
        line = 0;
        point = 1;
        point_x = X1 / X0;
        point_y = Y1 / Y0;
        if (point_x < 0 || point_y < 0) {
          puts("-1");
          exit(0);
        }
      }
    } else {
      line = 1;
      line_a = A;
      line_b = B;
      line_c = C;
    }
  }
  if (line) {
    std::map<int, std::pair<long long, long long> > ans;
    for (auto &i : a)
      ans.insert(
          {i.first,
           {i.second.first + i.second.second * first(line_a, line_b, line_c),
            i.second.second * -line_b}});
    return ans;
  } else if (point) {
    std::map<int, std::pair<long long, long long> > ans;
    for (auto &i : a)
      ans.insert({i.first, {point_x * i.second.second + i.second.first, 0}});
    return ans;
  } else
    return a;
}
int main() {
  scanf("%d", &N);
  for (int i = 0; i < N; i++) read(A[i]);
  while (N > 1) {
    A[N - 2] = merge(A[N - 2], A[N - 1]);
    N--;
  }
  long long O = 1;
  for (auto &i : A[0])
    O = O * POWER(i.first, i.second.first, 1000000007) % 1000000007;
  printf("%lld\n", O);
  return 0;
}
