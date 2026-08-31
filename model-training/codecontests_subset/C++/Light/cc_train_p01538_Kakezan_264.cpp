#include <iostream>
#include <set>
#include <algorithm>

using namespace std;
typedef long long ll;

int main(){
	int Q;
	cin >> Q;
	while(Q--){
		ll n;
		cin >> n;
		set<ll> passed;
		int step = 0;
		while(n >= 10){
			ll next = 0, lower = 0, dig = 1;
			while(n > 0){
				lower = lower + (n % 10) * dig;
				n /= 10;
				next = max(next, lower * n);
				dig *= 10;
			}
			++step;
			if(passed.find(next) != passed.end()){
				step = -1;
				break;
			}
			passed.insert(next);
			n = next;
		}
		cout << step << endl;
	}
	return 0;
}