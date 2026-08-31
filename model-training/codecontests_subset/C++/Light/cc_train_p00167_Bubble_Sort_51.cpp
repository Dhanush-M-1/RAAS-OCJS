#include<iostream>
#include<algorithm>
#include<map>

const int MAX_N = 100;
int bit[MAX_N+1], n;

int sum(int i){
	int s = 0;
	while(i > 0){
		s += bit[i];
		i -= i & -i;
	}
	return s;
}

void add(int i, int x){
	while(i <= n){
		bit[i] += x;
		i += i & -i;
	}
}

int main(){
	int a[MAX_N], b[MAX_N];
	while(std::cin >> n, n){
		for(int i=0;i<MAX_N+1;i++){
			bit[i] = 0;
		}

		for(int i=0;i<n;i++){
			std::cin >> a[i];
		}

		for(int i=0;i<n;i++){
			b[i] = a[i];
		}
		std::sort(b, b+n);
		std::map<int, int> m;
		for(int i=0;i<n;i++){
			m[b[i]] = i+1;
		}

		int t = 0;
		for(int i=0;i<n;i++){
			t += i - sum(m[a[i]]);
			add(m[a[i]], 1);
		}

		std::cout << t << std::endl;
	}
}