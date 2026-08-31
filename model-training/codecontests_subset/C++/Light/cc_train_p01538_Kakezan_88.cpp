#include <iostream>
#include <string>


using namespace std;

int main()
{
  int q;
  cin >> q;
  while(1){
	if (q <= 0) break;
	int n ;
	cin >> n;
	int count = 0;
	string hoge;
	hoge = to_string(n);
	while(1){
	  int max = 0;
	  int l = hoge.length();
	  if(l <= 1) break;
	  int i;
	  
	  for (i = 1; i < l; i++) {
		string a,b;
		int c,d;
		a = hoge.substr(0,i);
		b = hoge.substr(i);
		// cout << a << endl;
		// cout << b << endl;
		c = stoi(a);
		d = stoi(b);
		if(max < c * d) max  = c * d;
		// cout << max << endl;	
	  }
	  
	  count++;
	  if(max >= 10) hoge = to_string(max);
	  else break;
	}
	cout << count << endl;
	q--;
  }  
  return 0;
}