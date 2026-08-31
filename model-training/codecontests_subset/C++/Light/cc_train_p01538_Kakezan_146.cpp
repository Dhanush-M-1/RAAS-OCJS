#include<iostream>
#include<fstream>
#include<string>

using namespace std;

int search(int num){
    if(num < 10)return 0;

    auto log = 10;
    auto v = 0;
    while(log < num)
    {
        auto tmp = (num % log) * (num / log);
        v = max(tmp, v);
        log *= 10;
    }

    return 1 + search(v);

}


int main(){
    //ifstream fin("in.txt");

    auto n = 0;
    cin >> n;

    for(auto i = 0; i < n; i++){
        auto num = 0;
        cin >> num;
        cout << search(num) << endl;
    }

    return 0;
}