#include <iostream>
#include <vector>

using namespace std;

class Watch {
public:
	explicit Watch(int X) : X(X), startA(0), curA(0), startB(X), curB(X), up(true) {}
	int query(int time, int a){
		int cur = calcStart_(a) + (up ? -time : time);
		if(cur <= 0) return 0;
		if(cur >= X) return X;
		return cur;
	}
	int progress(int time){
		if(up){
			curA -= time;
			curB -= time;
			if(curB <= 0){
				startA = startB;
				curA = curB = 0;
			} else if(curA <= 0){
				startA -= curA;
				curA = 0;
			}
		} else {
			curA += time;
			curB += time;
			if(curA >= X){
				startB = startA;
				curA = curB = X;
			} else if(curB >= X){
				startB -= curB - X;
				curB = X;
			}
		}
		up = !up;
	}
private:
	int calcStart_(int a){
		if(a <= startA) return curA;
		if(a >= startB) return curB;
		return curA + a - startA;
	}
private:
	const int X;
	int startA, curA, startB, curB;
	bool up;
};

int main(){
	int X, K;
	while(cin >> X >> K){
		vector<int> times;
		times.push_back(0);
		for(int i=0;i<K;i++){
			int a; cin >> a;
			times.push_back(a);
		}
		times.push_back(1000000007);
		Watch watch(X);
		int timeIdx = 0;
		int Q; cin >> Q;
		for(int i=0;i<Q;i++){
			int t, a; cin >> t >> a;
			while(t >= times[timeIdx+1]){
				watch.progress(times[timeIdx+1] - times[timeIdx]);
				++timeIdx;
			}
			cout << watch.query(t - times[timeIdx], a) << endl;
		}
	}
}