#include <iostream>
#include <vector>
#include <set>
#include <queue>
#include <stack>


using namespace std;

int main(int, char**){
    int x;
    while(cin >> x,x){ 
	int vec[128];
	int cnt(0);
	for(int i(0);i<x;++i){
	    cin >> vec[i];
	}
	for(int i(x-1);i>0;--i){
	    for(int j(0);j<i;++j)
		if(vec[j] > vec[j+1]){ swap(vec[j],vec[j+1]); ++cnt; }
	}
	cout << cnt << endl;
    }
    return 0;
}