class CreateGames < ActiveRecord::Migration[6.0]
  def change
    create_table :games do |t|
      t.string :home-team
      t.string :away-team
      t.string :season
      t.string :season-type
      t.string :location
      t.string :week
      t.string :startTime
      t.string :endTime

      t.timestamps
    end
  end
end
