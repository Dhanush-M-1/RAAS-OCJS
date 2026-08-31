#include <bits/stdc++.h>
using namespace std;
struct BookInfo {
  int t;
  int a;
  int b;
  int i;
};
struct CombinedBook {
  int t;
  BookInfo b1;
  BookInfo b2;
  bool isCombined;
};
int main() {
  ios_base::sync_with_stdio(0);
  cout << fixed << setprecision(10);
  cerr << fixed << setprecision(10);
  cin.tie(0);
  int n, k;
  cin >> n >> k;
  vector<BookInfo> allBooks;
  int aliceLikes = 0;
  int bobLikes = 0;
  for (int i = 0; i < n; i++) {
    BookInfo info;
    cin >> info.t >> info.a >> info.b;
    info.i = i + 1;
    if (info.a) {
      aliceLikes++;
    }
    if (info.b) {
      bobLikes++;
    }
    allBooks.push_back(info);
  }
  if (aliceLikes < k || bobLikes < k) {
    cout << -1 << endl;
    return 0;
  }
  sort(allBooks.begin(), allBooks.end(),
       [](const BookInfo &a, const BookInfo &b) -> bool { return a.t < b.t; });
  vector<BookInfo> aliceBooks;
  vector<BookInfo> bobBooks;
  vector<CombinedBook> combined;
  vector<BookInfo> other;
  for (BookInfo &book : allBooks) {
    if (book.a && book.b) {
      CombinedBook item;
      item.t = book.t;
      item.b1 = book;
      item.b2 = book;
      item.isCombined = false;
      combined.push_back(item);
    } else if (!book.a && !book.b) {
      other.push_back(book);
    } else if (book.a) {
      aliceBooks.push_back(book);
    } else if (book.b) {
      bobBooks.push_back(book);
    }
  }
  for (int i = 0; i < n; i++) {
    if (i < aliceBooks.size() && i < bobBooks.size()) {
      CombinedBook item;
      item.isCombined = true;
      item.b1 = aliceBooks[i];
      item.b2 = bobBooks[i];
      item.t = item.b1.t + item.b2.t;
      combined.push_back(item);
    } else if (i < aliceBooks.size()) {
      other.push_back(aliceBooks[i]);
    } else if (i < bobBooks.size()) {
      other.push_back(bobBooks[i]);
    }
  }
  if (combined.size() < k) {
    cout << -1 << endl;
    return 0;
  }
  sort(combined.begin(), combined.end(),
       [](const CombinedBook &a, const CombinedBook &b) -> bool {
         return a.t < b.t;
       });
  vector<int> result;
  int sum = 0;
  int leftLikes = k;
  for (int i = 0; i < k; i++) {
    sum += combined[i].t;
  }
  cout << sum << endl;
}
