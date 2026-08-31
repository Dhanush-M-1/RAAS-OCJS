#include <iostream>
#include <string>
using namespace std;

void steps(int n);
int step(int n);

int main()
{
    int q;
    cin >> q;
    int n;
    for(int i = 0; i < q; i++){
        cin >> n;
        steps(n);
    }
    return 0;
}

void steps(int n)
{
    int count = -1;
    while(n != -1){
        n = step(n);
        count++;
    }
    cout << count << endl;
}

int step(int n)
{
    if(n < 10){
        return -1;
    }
    int fst = n;
    int snd = 0;
    int m = 10;
    int max = 0;
    while(fst > 0){
        fst /= 10;
        snd = n % m;
        m *= 10;
        if(max < fst * snd){
            max = fst * snd;
        }
    }
    return max;
}