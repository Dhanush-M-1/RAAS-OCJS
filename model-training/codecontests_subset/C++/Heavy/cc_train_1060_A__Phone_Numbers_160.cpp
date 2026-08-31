#include <bits/stdc++.h>
using namespace std;
void swap(char *x, char *y) {
  char temp;
  temp = *x;
  *x = *y;
  *y = temp;
}
bool isPalindrome(char str[]) {
  long long int l = 0;
  long long int h = strlen(str) - 1;
  while (h > l) {
    if (str[l++] != str[h--]) {
      return false;
    }
  }
  return true;
}
long long int anagram(char input[], long long int n) {
  long long int cnt = 0;
  sort(input, input + n);
  do {
    cout << input << endl;
    if (isPalindrome(input)) cnt++;
  } while (next_permutation(input, input + n));
  return cnt;
}
long long int permute(char *a, long long int l, long long int r) {
  long long int i, cnt = 0;
  if (l == r) {
    cout << a << endl;
    if (isPalindrome(a)) cnt++;
  } else {
    for (i = l; i <= r; i++) {
      swap((a + l), (a + i));
      permute(a, l + 1, r);
      swap((a + l), (a + i));
    }
  }
  return cnt;
}
int binarySearch(long long int arr[], int l, int r, int x) {
  int last = r;
  if (r >= l) {
    int mid = l + (r - l) / 2;
    if (x < arr[mid] && x >= arr[mid - 1]) {
      return mid;
    }
    if (arr[mid] > x) return binarySearch(arr, l, mid - 1, x);
    return binarySearch(arr, mid + 1, r, x);
  }
  return -1;
}
int quadratic(int a, int b, int c) {
  int x1, x2, discriminant;
  discriminant = b * b - 4 * a * c;
  if (discriminant > 0) {
    x1 = (-b + sqrt(discriminant)) / (2 * a);
    x2 = (-b - sqrt(discriminant)) / (2 * a);
    if (x1 > 0)
      return x1;
    else
      return x2;
  }
}
void print_arr(unsigned long long int arr[], long long int n) {
  long long int i;
  for (i = 0; i < n; i++) {
    cout << arr[i] << ' ';
  }
  cout << endl;
}
long long int bsearch(long long int prefixsum[], long long int n,
                      long long int k) {
  long long int ans = -1;
  long long int left = 1, right = n;
  while (left <= right) {
    long long int mid = (left + right) / 2;
    long long int i, s = 0, dd;
    for (i = mid; i <= n; i++) {
      dd = prefixsum[i] - prefixsum[i - mid];
      if (dd <= k) {
        s = 1;
        break;
      }
    }
    if (s) {
      left = mid + 1;
      ans = max(mid, ans);
      s = 0;
    } else
      right = mid - 1;
  }
  if (ans == -1) ans++;
  return ans;
}
void scn_arr(long long int arr[], long long int n) {
  long long int i;
  for (i = 0; i < n; i++) {
    scanf("%lld", &arr[i]);
  }
}
long long int maxSizeBelowK(long long int arr[], long long int n,
                            long long int k) {
  long long int prefixsum[n + 1], i;
  memset(prefixsum, 0, sizeof(prefixsum));
  for (i = 0; i < n; i++) prefixsum[i + 1] = prefixsum[i] + arr[i];
  return bsearch(prefixsum, n, k);
}
long long int GCD(long long int a, long long int b) {
  if (b == 0) return a;
  return GCD(b, a % b);
}
long long int LCM(long long int a, long long int b) {
  return b * a / GCD(a, b);
}
bool sortbysec(const pair<int, int> &a, const pair<int, int> &b) {
  return (a.second < b.second);
}
bool *SieveOfEratosthenes(int n, bool *prime) {
  for (int p = 2; p * p <= n; p++) {
    if (prime[p] == true) {
      for (int i = p * 2; i <= n; i += p) prime[i] = false;
    }
  }
  return prime;
}
bool isPrime(long long int n) {
  long long int i, h;
  if (n <= 1) return false;
  if (n == 2) return true;
  if (n % 2 == 0) return false;
  h = sqrt(n);
  for (i = 3; i <= h; i += 2) {
    if (n % i == 0) {
      return false;
    }
  }
  return true;
}
void combinationUtil(long long int arr[], long long int n, long long int r,
                     long long int index, long long int data[],
                     long long int i) {
  if (index == r) {
    for (int j = 0; j < r; j++) printf("%d ", data[j]);
    printf("\n");
    return;
  }
  if (i >= n) return;
  data[index] = arr[i];
  combinationUtil(arr, n, r, index + 1, data, i + 1);
  combinationUtil(arr, n, r, index, data, i + 1);
}
long long int countBits(long long int number) {
  return (long long int)log2(number) + 1;
}
void printCombination(long long int arr[], long long int n, long long int r) {
  long long int data[r];
  combinationUtil(arr, n, r, 0, data, 0);
}
long long int ASCIIofString(string str) {
  long long int sum = 0;
  long long int len = str.length();
  for (long long int i = 0; i < len; i++) sum += (int)str[i];
  return sum;
}
bool isPowerOfTwo(long long int x) { return (x && !(x & (x - 1))); }
int leftRotate(int n, unsigned int d) { return (n << d) | (n >> (7 - d)); }
void leftRotatebyOne(string s, long long int n) {
  long long int i;
  char temp = s[0];
  for (i = 0; i < n - 1; i++) s[i] = s[i + 1];
  s[i] = temp;
}
long long int lowestSetBit(long long int num) { return (num & (-num)); }
long long int countSetBits(long long int num) {
  long long int cnt = 0;
  while (num) {
    num &= (num - 1);
    cnt++;
  }
  return cnt;
}
long long int toggleBit(long long int num, long long int pos) {
  return num ^ (1 << pos);
}
int _lis(int arr[], int n, int *max_ref) {
  if (n == 1) return 1;
  int res, max_ending_here = 1;
  for (int i = 1; i < n; i++) {
    res = _lis(arr, i, max_ref);
    if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here)
      max_ending_here = res + 1;
  }
  if (*max_ref < max_ending_here) *max_ref = max_ending_here;
  return max_ending_here;
}
int lis(int arr[], int n) {
  int max = 1;
  _lis(arr, n, &max);
  return max;
}
int lds(int arr[], int n) {
  int lds[n];
  int i, j, max = 0;
  for (i = 0; i < n; i++) lds[i] = 1;
  for (i = 1; i < n; i++)
    for (j = 0; j < i; j++)
      if (arr[i] < arr[j] && lds[i] < lds[j] + 1) lds[i] = lds[j] + 1;
  for (i = 0; i < n; i++)
    if (max < lds[i]) max = lds[i];
  return max;
}
void factArr(long long int n, unsigned long long int *arr, long long int mod) {
  for (long long int i = 0; i <= n; i++) {
    if (!i || i == 1)
      arr[i] = 1;
    else if ((arr[i - 1] * i) % mod == 0)
      arr[i] = 1;
    else
      arr[i] = (arr[i - 1] * i) % mod;
  }
}
unsigned long long int fastPow(long long int x, unsigned long long int y,
                               long long int p) {
  long long int res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
int main() {
  long long int cnt8 = 0, n, i, num;
  string nums;
  cin >> n;
  cin >> nums;
  num = n / 11;
  for (i = 0; i < n; i++) {
    if (nums[i] == '8') cnt8++;
  }
  if (n < 11 || !cnt8)
    cout << "0";
  else
    cout << min(cnt8, num);
  return 0;
}
